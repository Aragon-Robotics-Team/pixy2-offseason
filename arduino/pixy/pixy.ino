#include <Pixy2.h>
const int kFocal = (35 * 19) / 9.5;

Pixy2 pixy;
void setup() {
  Serial.begin(115200);
  Serial.print("Woah its working\n");

  pixy.init();
}

void loop() {
  
  int8_t code = pixy.ccc.getBlocks(true, 0b1, 1);

  if (pixy.ccc.numBlocks > 0) {
    Block target = pixy.ccc.blocks[0];
    Serial.println(9.5 * kFocal / target.m_width);
  }
}
