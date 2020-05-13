void setup(){
  //시리얼통신을 시작하겠다는 의미 -시리얼 통신을 위해 기본작업을 수행
  Serial.begin(9600);//통신속도 정의
}
void loop(){
  Serial.println("Hello 아두이노");
  delay(1000);
}
