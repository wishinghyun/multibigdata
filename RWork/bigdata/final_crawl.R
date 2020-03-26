####모두의 광장의 1페이지부터 10페이지까지의 모든 게시글 크롤링####
#1. 모든 페이지의 title,hit,url,content 추출하기
#2. crawl_result.csv, crawl_result.RData 저장
#3. mongodb저장 (300개 저장)
#4. for문, if문을 활용

library("stringr")
library("mongolite")

con <- mongo(collection = "crawl",
             db = "bigdata",
             url = "mongodb://127.0.0.1")

#0번부터 9번 페이지까지 반복 작업
final_data_list = NULL
for (i in 0:9) {
  #페이지마다 연결할 주소가 달라지므로 변수로 처리
  furl <- paste0("https://www.clien.net/service/group/community?&od=T31&po=",i)
  furl_data <- readLines(furl,encoding = "UTF-8")
  ####title 추출####
  ffilter_data <- furl_data[str_detect(furl_data,"subject_fixed")]
  ftitle <- str_extract(ffilter_data,"(?<=\">).*(?=</span>)")
  ####hit추출####
  fhit_data <- furl_data[str_detect(furl_data,"<span class=\"hit\">")]
  fhit <- str_extract(fhit_data,"(?<=\">).*(?=</span>)")[-1]
  ####url추출####
  str_detect(url_data,"subject_fixed")
  fmyurl <- furl_data[which(str_detect(furl_data,"subject_fixed"))-3]
  furl_val <- str_extract(fmyurl,"(?<=href=\").*(?=data-role)")
  furl_val <- str_sub(furl_val,end = -3)
  furl_val <- paste0("https://www.clien.net",furl_val)


##############url을 이용해서 content항목 추출###############
contentlist=NULL #최초 변수 선언시 null로 초기화
content_filter_data=NULL
  for (page in 1:length(furl_val)) {
    contentdata <- readLines(as.character(furl_val[page]),encoding = "UTF-8")
    start = which(str_detect(contentdata,"post_content"))
    end = which(str_detect(contentdata,"post_ccls"))
    
    content_filter_data <- contentdata[start:end]
    content_filter_data <- paste(content_filter_data,collapse = "")
    content_filter_data <- gsub("<.*?>","",content_filter_data)
    content_filter_data <- gsub("\t|&nbsp;","",content_filter_data)
    #기존의 저장되어 있는 contentlist의 내용에 추가
    contentlist <- c(contentlist,content_filter_data)
    cat("\n",page)
  }

final_data <- cbind(ftitle,fhit,furl_val,contentlist)
final_data_list <- rbind(final_data_list,final_data)
cat("\n",i)

}


####csv파일로 생성####
final_data_list
write.csv(final_data_list,file = "crawl_data.csv")
#R에서 사용할 파일로 저장하는게 속도가 빠름 확장자명 .RData
save(final_data_list,file = "crawl_data.RData")


####mongodb에 저장하기####
if(con$count()>0){
  con$drop()
}
final_mongo_data <- data.frame(final_data_list)
con$insert(final_mongo_data)




