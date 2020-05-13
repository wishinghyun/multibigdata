int pin[3] = {A0,A1,A2};
int pin_length = sizeof(pin)/sizeof(int);
void setup() {
  pinMode(pin[0],OUTPUT);
  pinMode(pin[1],OUTPUT);
  pinMode(pin[2],OUTPUT);
}

void loop() {
  for(int i=0;i<pin_length;i++){
    digitalWrite(pin[i],HIGH);
    delay(1000);
    digitalWrite(pin[i],LOW);
    delay(1000);
  }
}
