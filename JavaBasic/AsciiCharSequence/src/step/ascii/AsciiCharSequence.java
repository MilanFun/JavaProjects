package step.ascii;

public class AsciiCharSequence implements java.lang.CharSequence{
    private byte[] buf;

    public AsciiCharSequence(byte[] buf) {
        this.buf = buf;
    }

    @Override
    public int length() {
        return this.buf.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.buf[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] arrNew = new byte[end - start];
        for(int i = start, j = 0; i < end; i++, j++) {
            arrNew[j] = this.buf[i];
        }
        return new AsciiCharSequence(arrNew);
    }

    @Override
    public String toString() {
        return new String(this.buf);
    }

}
