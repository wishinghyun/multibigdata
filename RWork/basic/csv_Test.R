#csv는 기본 패키지로 사용가능
#csv를 읽기
mdf = read.csv("csv_exam.csv")
mdf
mdf[2,]
#dataframe에서 조건에 만족하는 데이터를 조회
m <- matrix(1:20,ncol = 4)
m
d <- data.frame(m)
d
myresult <- d[d$X3>=13,]
myresult
#조건에 만족하는 데이터를 result.csv로 저장
write.csv(myresult,file = "result.csv")
science <- mdf[mdf$science>=80,]
science
total <- c(sum(science[1,(3:5)]),sum(science[2,(3:5)]),sum(science[3,(3:5)]),sum(science[4,(3:5)]))
x <- 1
for (i in science$mytotal[x]/length(science[,(3:5)])) {
  x = x + 1
}
total
science$mytotal <- total
science
avg_exam <- c(science$mytotal[1]/length(science[,(3:5)]),science$mytotal[2]/length(science[,(3:5)]),science$mytotal[3]/length(science[,(3:5)]),science$mytotal[4]/length(science[,(3:5)]))
avg_exam
science$myavg <- avg_exam
science
write.csv(science,file = "csv_exam_result.csv")
