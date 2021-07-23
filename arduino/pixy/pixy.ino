#include <Pixy2.h>
#include <Pixy2CCC.h>

//Focal Point Formula
const int kFocal = (106 * 20) / 9.25;

Pixy2 pixy;
void setup() {

  //baud num
  Serial.begin(115200);

  //start print
  Serial.print("Woah its working\n");

  pixy.init();
}

void loop() {
  
  int8_t code = pixy.ccc.getBlocks(true, 0b1, 1);
  //Serial.print("Woah its a start\n");
  
  if (pixy.ccc.numBlocks > 0) {
    Block target = pixy.ccc.blocks[0];

    //Block detected print
    Serial.print("Woah we detected\n");
    
    //Distance Formula
    Serial.println(9.25 * kFocal / target.m_width);

    //Debugging
//    Serial.print("Width:");
//    Serial.println(target.m_width);
//    Serial.print("Height:");
//    Serial.println(target.m_height);
    }
  }
