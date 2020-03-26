install.packages("mongolite")
library("stringr")
library("mongolite")

#mongodb에 저장하기 위해서는 크롤링해야 한다
#collection은 이름 정해주는거, db는 mongodb의 use id, url은 몽고디비 주소
con <- mongo(collection = "crawl",
             db = "bigdata",
             url = "mongodb://127.0.0.1")


url <- "https://www.clien.net/service/group/community?&od=T31&po=3" #페이지 url
url_data <- readLines(url,encoding = "UTF-8")
url_data
#정보 확인용========필요 없음
#class(url_data)
#length(url_data)
#head(url_data)
#tail(url_data)
#============================

url_data[200]
#조건에맞족하는 데이터를 필터링
#문자열에 패턴을 적용해서 일치 여부를 T/F로 리턴

####데이터 필터링 : title####
#1. str_detect(패턴을 검사할 문자열, 패턴)를 이용해서 웹페이지 전체에서 필요한 데이터만 먼저 추출
#str_detect(url_data,"subject_fixed") 클래스 명 : subject_fixed
filter_data <- url_data[str_detect(url_data,"subject_fixed")]
filter_data
#2. 추출한 데이터 전체에서 내가 필요한 문자열만 추출
#str_extract <- 패턴에 일치하는 문자열을 리턴
#후방,전방 탐색 정규 표현식 이용
# /"> , </span> 사이의 문자 (패턴 포함하지 않음)
title <- str_extract(filter_data,"(?<=\">).*(?=</span>)")
title

####데이터 필터링 : hit(조회수)####
hit_data <- url_data[str_detect(url_data,"<span class=\"hit\">")]
hit_data
hit <- str_extract(hit_data,"(?<=\">).*(?=</span>)")[-1]
hit

####데이터 필터링 : url####
str_detect(url_data,"subject_fixed") #true / false

myurl <- url_data[which(str_detect(url_data,"subject_fixed"))-3]
myurl
url_val <- str_extract(myurl,"(?<=href=\").*(?=data-role)")
url_val
#필요없는 문자열을 잘라내기
url_val <- str_sub(url_val,end = -3)
url_val <- paste0("https://www.clien.net",url_val)
url_val

####csv파일로 생성####
final_data <- cbind(title,hit,url_val)
final_data
write.csv(final_data,file = "crawl_data.csv")
#R에서 사용할 파일로 저장하는게 속도가 빠름 확장자명 .RData
save(final_data,file = "crawl_data.RData")

#갯수 확인용
length(title)
length(hit)
length(url_val)

####mongodb에 저장하기####
if(con$count()>0){
  con$drop()
}
final_data
class(final_data)
final_data <- data.frame(final_data)
class(final_data)
con$insert(final_data)






