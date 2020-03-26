install.packages("stringr")
library("stringr")
#패턴
mytext <- "      test$uuuuu"
mytext2 <- "https://cran.r-project.org/"
#패턴 실행해주는 function - str_extract
str_extract(mytext2,".+(:)")   # ":" 패턴과 일치하는 문자열도 리턴
str_extract(mytext2,".+(?=:)") # ":" 패턴과 일치하는 문자열 전까지 리턴(?=)
str_extract(mytext,"(?<=\\$).*") # 후방 탐색 (?<=)

#문자열 관련 함수
#paste  - 벡터를 연결해서 하나의 문자열로 생성
#paste0 - 여러 개를 연결
str <- c("java","hadoop","R","mongodb")
paste(str,collapse = " ") #collapse로 연결시켜줌
paste(str,collapse = ",")
paste0(mytext,mytext2) #문자열 1개로 연결
data <- gsub("u","",mytext)  #특정 문자 치환 
data
str_trim(data)











