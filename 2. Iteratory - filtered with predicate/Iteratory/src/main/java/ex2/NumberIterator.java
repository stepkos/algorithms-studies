package ex2;

public class NumberIterator implements Iterator<Integer> {

    private final Integer maxNumber;
    private Integer currentNumber = 1;

    public NumberIterator(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public void first() {
        currentNumber = 1;
    }

    @Override
    public void last() {
        currentNumber = maxNumber;
    }

    @Override
    public void next() {
        currentNumber++;
    }

    @Override
    public void previous() {
        currentNumber--;
    }

    @Override
    public boolean isDone() {
        return currentNumber > maxNumber || currentNumber < 1;
    }

    @Override
    public Integer current() {
        return currentNumber;
    }

}
