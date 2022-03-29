public class SelectionImpl implements Selection{
    
    private int Ideb = 0;
    private int Ifin = 0;
    private int Bdeb = 0;
    private int Bfin = 0;

    @Override
    public int getBeginIndex() {
        return Ideb;
    }

    @Override
    public int getEndIndex() {
        return Ifin;
    }

    @Override
    public int getBufferBeginIndex() {
        return Bdeb;
    }

    @Override
    public int getBufferEndIndex() {
        return Bfin;
    }

    @Override
    public void setBeginIndex(int beginIndex) {
        Ideb = beginIndex;
    }

    @Override
    public void setEndIndex(int endIndex) {
        Ifin = endIndex;
    }

}
