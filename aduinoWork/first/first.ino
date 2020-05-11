void setup(){
  //시리얼통신을 시작하겠다는 의미 -시리얼 통신을 위해 기본작업을 수행
  Serial.begin(9600);//통신속돌 정
}
void loop(){
  Serial.println("Hello 앋둥인");
  delay(1000);
}
