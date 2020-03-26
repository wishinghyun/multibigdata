library("stringr")
library("mongolite")


#[실습]
#crawl_content
#final_data의 1번 글의 내용을 출력

load(file = "crawl_data.RData")
final_data
url_list <- final_data[,3]
class(url_list)
#웹페이지 데이터 가져오기
contentdata <- readLines(as.character(url_list[1]),encoding = "UTF-8")
class(contentdata)

#원하는 부분만 가져오기
start = which(str_detect(contentdata,"post_content"))
end = which(str_detect(contentdata,"post_ccls"))
start
end
content_filter_data <- contentdata[start:end]
content_filter_data

#데이터 정제하기
#1. 벡터로 리턴하므로 한 개로 합치기
content_filter_data <- paste(content_filter_data,collapse = "")
content_filter_data
#2. 불필요한 기호나 태그를 없애기
#<로 시작하고 >로 끝나는 태그안의 모든 문자 없앰 (<p>)
content_filter_data <- gsub("<.*?>","",content_filter_data)
content_filter_data
#&nbsp;   :  space로 된 공백 지움 (\t)
content <- gsub("\t|&nbsp;","",content_filter_data)
content











