//시리얼통신으로 입력받은 값을 이용해서 LED를 제어
//1이라는 값이 입력되면 LED를 On
//0이 입력되면 LED를 Off
#define LED A2
char cmd;
void setup() {
  Serial.begin(9600);
  pinMode(LED,OUTPUT);
}

void loop() {
  if(Serial.available()>0){
    cmd = Serial.read();
    if(cmd=='1'){
      digitalWrite(LED,HIGH);
    }else if(cmd=='0'){
      digitalWrite(LED,LOW);
    }
  }
}
