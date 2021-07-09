#include <Pixy2.h>

Pixy2 pixy;
void setup() {
  Serial.begin(115200);
  Serial.print("Woah its working\n");

  pixy.init();
}

void loop() {

  pixy.ccc.getBlocks();

  for (int i = 0; i < pixy.ccc.numBlocks; i++) {
    pixy.ccc.blocks[i].print();
    }
}
