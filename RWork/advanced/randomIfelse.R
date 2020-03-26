set.seed(1222) #숫자는 key
a <- sample(1:10,size = 5,replace = FALSE)
a
#if문의 역할을 하는 함수 - ifelse
set.seed(1221)
ifdf <- data.frame(mynum=1:6,
                   myval=sample(c("spring","bigdata","android"),
                                size = 6,
                                replace = TRUE))
ifdf
#myval의 값이 spring이면 프로젝트 완료, bigdata이면 할꺼야 출력
for (i in 1:nrow(ifdf)) {
  if(ifdf[i,"myval"]=="spring"){
    ifdf[i,"info"] <- "프로젝트 완료"
  }else{
    ifdf[i,"info"] <- "할꺼야"
  }
}
ifdf

#함수를 이용해서 - info2
ifdf[,"info2"] <- ifelse(test = ifdf$myval=="spring",
                         yes = "쉽다",
                         no = "할꺼다")


#조건이 두 개 이상인 경우 처리
ifdf[,"info3"] <- ifelse(test = ifdf$myval=="spring",
                         yes = "쉽다",
                         no = ifelse(test = ifdf$myval=="bigdata",
                                     yes = "머신셋팅",
                                     no = "device셋팅완료"))
ifdf

ifdf[,"info4"] <- "쉽다"
ifdf
#ifdf[,"info4"] <- ifelse(test = ifdf$myval=="bigdata",
#                         yes = "머신셋팅",
#                         no = "device셋팅완료"))
#ifdf







