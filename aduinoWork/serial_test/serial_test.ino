void setup(){
  Serial.begin(9600);
}
void loop(){
  Serial.println("READY...");
  delay(3000);
  //Serial.available()은 입력값이 있는지 판단 - 통신으로 입력받는 값을 읽기
  //전에 반드시 체크를 하고 시작, 시리얼 통신이 가능하지 체크하는
  if(Serial.available()>0){
    //Serial.read()는 한 바이트씩 읽고 읽은 바이트를 버퍼에서 지운다. 읽을 값이 없으면 -1을 리턴
    //버퍼의 맨 앞에 바이트를 하나 읽고 읽을때마다 읽은 바이트가 사라지면서 버퍼에 남은 데이터가 하나씩 담겨진다
    if(Serial.read()=='s'){
      //센서나 led등 엑추에이터 장치를 동작하라고 명령
      Serial.println("start...");
    }else{
      //센서나 led등 엑추에이터 장치를 STOP하라고 명령
      Serial.println("stop...");
    }
  }
}
