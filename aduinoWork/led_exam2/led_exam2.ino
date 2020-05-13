int pin[2] = {A0,A1};
int pin_length = sizeof(pin)/sizeof(int);
void setup() {
  Serial.begin(9600);
  pinMode(pin[0],OUTPUT);
  pinMode(pin[1],OUTPUT);
}

void loop() {
  if(Serial.available()>0){
    String data = Serial.readStringUntil('\n');
    Serial.println(data);
    if(data.equals("A0입력")){
      digitalWrite(pin[1],LOW);
      digitalWrite(pin[0],HIGH);
    }else {
      digitalWrite(pin[0],LOW);
      digitalWrite(pin[1],HIGH);
    }
  }
}
