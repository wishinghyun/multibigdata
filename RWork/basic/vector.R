# =, <- 같은 것 처럼 보이지만 <- 를 이용해서 변수에 데이터를 할당
a = 100
b <- 100
a
b
sqrt(9)
sqrt(x=9) #x는 함수의 매개변수로 인식
x
sqrt(x <- 9) #x라는 변수로 활용
x
? c
myvector1 <- c(100,200,300)
myvector1
myvector1[1]
myvector1[2]
myvector1[3]
myvector2 <- c(10,20,30)
myvector1
myvector2
myvector1 + 20
myvector1 *2
myvector1 + myvector2
mytext <- c("java","R","hadoop","android")
mytext[1]
mytext[1,2] #matrix에 사용하므로 벡터에서 쓸 수 없다
mytext[c(1,2)] #벡터의 1번요소와 2번요소만 출력
mytext[c(1,3)]
mytext[1:3]
mytext[c(1:3)] #1번에서 3번까지의 요소 선택
1:3
1:100
mytext[-1] #1번요소 제외한 나머지
mytext[c(-1,-3)]
mytext[c(-1:-3)]
mytext[-c(1:3)]

#TRUE(T)와 FALSE(F)를 이용해서 작업하기
mytext[c(T,T,F,F)] #TRUE로 표현된 요소만 출력
mytext[mytext=="java"] #조건을 만족하는 요소
numlist <- 1:100
numlist
numlist %%2==0 #%%가 나머지 구하기
numlist[numlist %%2==0] #짝수구하기
numlist[numlist %%2==1] #홀수구하기
numlist2 <- seq(1,10)
numlist2
numlist2 <- seq(1,10,by = 2)
numlist2
v1 <- c(70,80,90,100)
names(v1) #names는 벡터의 이름을 출력
names(v1) <- c("국어","수학","영어","자바")
v1
length(v1) #요소의 갯수
mean(v1) #평균
max(v1) #최대값
min(v1) #최소값
