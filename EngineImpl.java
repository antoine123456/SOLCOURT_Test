public class EngineImpl implements Engine {
    /**
     * Provides access to the selection control object
     *
     * @return the selection object
     */

    private final Selection selection = new SelectionImpl();
    private final StringBuffer bu = new StringBuffer();
    private final StringBuffer cp = new StringBuffer();
    @Override
    public Selection getSelection() {
        // TODO
        return selection;
    }

    /**
     * Provides the whole contents of the buffer, as a string
     *
     * @return a copy of the buffer's contents
     */
    @Override
    public String getBufferContents() {
        // TODO
        return bu.toString();
    }

    /**
     * Provides the clipboard contents
     *{@inheritDoc}
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
        // TODO
        return cp.toString();
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */


    @Override
    public void cutSelectedText() {
        // TODO
        /*
        int start= selection.getBeginIndex();
        int end= selection.getEndIndex();
        System.out.println(end);

        //delete clipboard content
        int fin = cp.length();
        cp.delete(0,fin);
        // add selection to clipboard
        String selStr = bu.substring(start,end);
        cp.append(selStr);*/
        copySelectedText();
        //delete bu content selection
        delete();
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
        // TODO
        int start= selection.getBeginIndex();
        int end= selection.getEndIndex();
        //delete cp content
        int fin = cp.length();
        cp.delete(0,fin);
        // add selection to clipboard
        String selStr = bu.substring(start,end);
        cp.append(selStr);
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
        // TODO
        String content = cp.toString();
        insert(content);
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
        delete();
        int start  = selection.getBeginIndex();
        bu.insert(start,s);
        int len = s.length();
        selection.setBeginIndex(start+len);
        selection.setEndIndex(start+len);
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
        int start = selection.getBeginIndex();
        int end = selection.getEndIndex();
        bu.delete(start,end);
        selection.setEndIndex(start);
    }
}
