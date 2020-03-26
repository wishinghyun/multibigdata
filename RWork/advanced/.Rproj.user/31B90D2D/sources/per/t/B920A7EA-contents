#주어진 데이터에서 원하는 데이터만 추출
#dplyr은 문자열에 대한 작업에 특화된 기능이 많은 패키지
#c++로 구현되어 있어 가장 빠르다
#dplyr라이브러리는 실행할때 코드 전체를 범위지정해서 실행
library("dplyr")
data("airquality")
head(airquality)

df2 <- airquality
df2

#필터링 - 벡터연산
head(df2[,1:4])
df2_data1 <- df2[1:5,]
df2_data1
df2[df2$Day==1,]
df2[df2$Day!=1,]
df2[df2$Day<=2,]
df2[df2$Day==1 & df2$Day==2,]
df2[df2$Day==1 | df2$Day==2,]

df2$Day %in% 1:2 #true/false 반환
sum(df2$Day %in% 1:2) #조건 만족하는 것(true)의 갯수

df2_data2 = df2[df2$Day %in% 1:2,]
nrow(df2_data2)

#dplyr패키지에서 지원하는 필터관련 함수
filter(df2,Day==1 & Month==5) # df2에서 day가 1, month가 5인 데이터
filter(df2,Day %in% c(1,3,5)) # df2에서 day가 1,3,5 인 데이터

exam <- read.csv("csv_exam.csv")
exam

#filter : 조건을 정의
exam %>% 
  filter(class==1) %>% 
  filter(math>=50)

exam %>% 
  filter(class==1) %>% 
  select(id,math,science)

#select
exam %>% select(-math)
exam %>% select(id,math,english)

#arrange
exam %>% arrange(id)   # id로 정렬
exam %>% arrange(desc(id))  #desc는 내림차순
exam %>% arrange(class,desc(english))

#mutate : 파생변수 추가하기 (원본에 없는 컬럼 추가)
exam %>% 
  mutate(total=math+english+science) %>% 
  head()

exam %>% 
  mutate(total=math+english+science,
         mean=total/3) %>%
  head()

exam %>% 
  mutate(total=math+english+science,
         mean=total/3,
         info=ifelse(science>70,"통과","재시험"))

#group_by
exam %>% 
  group_by(class) %>% 
  summarise(math_sum = sum(math),
            math_mean = mean(math),
            math_median = median(math),
            math_count = n())








test1 <- data.frame(id = c(1,2,3,4,5),
                    mid_jumsu = c(77,56,99,100,99))
test2 <- data.frame(id = c(1,2,3,4,5),
                    final_jumsu = c(77,56,99,100,99))
test1
test2
final_data <- left_join(test1,test2,by = "id")
final_data

namedata <- data.frame(class = c(1,2,3,4,5),
                       teacher = c("kim","lee","park","jang","hong"),
                       stringsAsFactors = F)
str(namedata)
exam_new <- left_join(exam,namedata,by="class")
exam_new

groupA <- data.frame(id = c(1,2,3,4,5),
                    mid_jumsu = c(77,56,99,100,99))
groupB <- data.frame(id = c(6,7,8,9,10),
                     mid_jumsu = c(77,56,99,100,99))

group_total <- bind_rows(groupA,groupB)
group_total
