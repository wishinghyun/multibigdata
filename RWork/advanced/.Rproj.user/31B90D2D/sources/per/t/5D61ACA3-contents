library("ggplot2")
library("dplyr")
midwest <- as.data.frame(midwest)
head(midwest)
midwest <- rename(midwest, total=poptotal)
midwest <- rename(midwest, asian=popasian)
midwest$"전체 인구 대비 아시아 인구 백분율" <- midwest$asian/midwest$total
summary(midwest$"전체 인구 대비 아시아 인구 백분율")
midwest[,"아시아 인구 비율"] <- ifelse(test = midwest$"전체 인구 대비 아시아 인구 백분율">0.004872,
                                yes = "large",
                                no = "small")
table(midwest$"아시아 인구 비율")
qplot(data = midwest, x = midwest$"아시아 인구 비율" )
midwest
