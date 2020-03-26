dataframeMat1 <- matrix(1:15,ncol = 3,byrow = T)
dataframeMat1
mydataframe <- data.frame(dataframeMat1)
mydataframe
dataframeMat1[,1]
mydataframe[,1]
#matrix로 정의된 데이터를 dataframe으로 변경하여 작업하는 경우가 많음
#matrix의 1열만 char타입으로 변경
#matrix는 한 타입으로만 선언해야 하므로 한 열의 타입을 변경해도 모든 데이터의 타입이 변경된다
dataframeMat1[,1] <- as.character(dataframeMat1[,1])
dataframeMat1

#str함수는 dataframe내부의 데이터형을 볼 수 있는 함수
str(mydataframe)
mydataframe[,1] <- as.character(mydataframe[,1])
mydataframe

mydataframe$X1 #$를 이용해서 열의 이름을 접근할 수 있다
mydataframe$X2
mydataframe$X3

#dataframe에 열을 추가
col4 <- c(1,1,1,1,1)
mydataframe$X4 <- col4
mydataframe

#필요한 곳에서 dataframe을 다시 matrix로 변환
dataframeMat2 <- as.matrix(mydataframe)
dataframeMat2
