char inputdata = 0;
void setup(){
  Serial.begin(9600);
}
void loop(){
  int intdata = 65;
  char chardata = 65;
  float floatdata = 65;
//  Serial.println(intdata);
//  Serial.println(chardata);
//  Serial.println(floatdata);
  delay(1000);
  if(Serial.available()>0){
    inputdata = Serial.read();
    Serial.write(inputdata);
    Serial.print(",");
    Serial.println(inputdata);
    delay(1000);
  }
}
