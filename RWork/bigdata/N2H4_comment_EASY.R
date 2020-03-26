install.packages("N2H4")
library(N2H4)
library(stringr)
library(dplyr)
url <- "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=100&oid=020&aid=0003276790"
getAllComment(url) %>% 
  select(userName, contents) -> mydata
mydata
mycomment <- mydata$contents
mycomment
