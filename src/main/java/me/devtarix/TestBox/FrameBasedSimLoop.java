package me.devtarix.TestBox;

public class FrameBasedSimLoop extends SimLoop {
    @Override
    protected void processSimLoop() {
        while (isGameRunning()) {
            processInput();
            update();
            render();
        }
    }

    protected void update() {
        double cInt = controller.getL();
        controller.setL(cInt+1);
        controller.setX();
    }
}
