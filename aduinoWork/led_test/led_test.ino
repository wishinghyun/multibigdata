int pin = A2;
void setup() {
  //아두이노의 입출력핀을 초기화
  //pinMode(사용하는 핀번호,핀의 용도)
  //ㅍㅣㄴㅇㅡㅣㅇㅛㅇㄷㅗ : OUTPUT=>output용 핀, INPUT=> input용 핀
  pinMode(pin,OUTPUT);
}

void loop() {
  //디지털 핀의 전압을 LOW,HIGH로 설정 =>LOW:0V,HIGH 5V
  digitalWrite(pin,HIGH);
  delay(1000);
  digitalWrite(pin,LOW);
  delay(1000);
}
