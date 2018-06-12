@SubmarineAnnotation(
        submarineType = "Atomic",
        innerClasses = {"EngineForAtomicSubmarine"},
        creationCostInRoubles = 12_000_000_000L
)
public class AtomicSubmarine {

    private EngineForAtomicSubmarine engine;

    public AtomicSubmarine(String engineNoise) {
        this.engine = new EngineForAtomicSubmarine(engineNoise);
    }

    public void goSailing()
    {
        engine.startEngineNcycles(10);
    }


    class EngineForAtomicSubmarine{
        public EngineForAtomicSubmarine(String engineNoise) {
            this.engineNoise = engineNoise;
        }
        public void startEngineNcycles(int nCycles) {
            for(int i=0; i<nCycles; i++)
                System.out.println(engineNoise);
        }

        private final String engineNoise;

    }



    public static void main(String[] args) {
        AtomicSubmarine aSub = new AtomicSubmarine("vroom-vroom!");
        aSub.goSailing();
    }

}
