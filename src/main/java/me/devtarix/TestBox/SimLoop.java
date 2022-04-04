package me.devtarix.TestBox;

public abstract class SimLoop {
    protected volatile SimStatus status;
    protected SimController controller;
    private Thread simThread;
    private DataCSVOutput dataout;

    public float FRAMENUM = 0;

    public int millis = 50;

    public SimLoop() {
        controller = new SimController();
        status = SimStatus.STOPPED;

        this.dataout = new DataCSVOutput();
    }

    public void run() {
        status = SimStatus.RUNNING;
        simThread = new Thread(this::processSimLoop);
        simThread.start();
    }

    public void stop() {
        status = SimStatus.STOPPED;
        dataout.closeFile();
    }

    public boolean isGameRunning() {
        return status == SimStatus.RUNNING;
    }

    protected void processInput() {
        try {
            simThread.sleep(millis);
        } catch (Exception e) {
            Main.print(e.getMessage());
        }
    }

    protected void render() {
        String out = Double.toString(controller.getX());
        dataout.writeToFile(controller.getL()+","+ controller.getX()+"\n");

        outputFN(out);
    }

    protected void outputFN(String msg) {
        System.out.println(FRAMENUM++ + " " + msg);
    }

    protected abstract void processSimLoop();
}
