package by.training.nc.dev5.beans.test;

/**
 * This class describes entity <b>Variant</b>
 * that represents variant of question answer
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */
public class Variant {
    private int id;
    private String text;
    private int number;
    private boolean rightness;

    /**
     * Creates new entity of the class <b>{@code Variant}</b> and initialize it
     *
     * @param id        - id
     * @param text      - text
     * @param number    - the number of variant in the question
     * @param rightness -rightness of variant
     */
    public Variant(int id, String text, int number, boolean rightness) {
        this.id = id;
        this.text = text;
        this.number = number;
        this.rightness = rightness;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id to set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return text
     */

    public String getText() {
        return text;
    }

    /**
     *
     * @param text text to set
     */

    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return variant number
     */

    public int getNumber() {
        return number;
    }

    /**
     *
     * @param number number to set
     */

    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return rightness
     */
    public boolean isRightness() {
        return rightness;
    }

    /**
     *
     * @param rightness rightness to set
     */

    public void setRightness(boolean rightness) {
        this.rightness = rightness;
    }
    /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variant variant = (Variant) o;

        if (id != variant.id) return false;
        if (number != variant.number) return false;
        if (rightness != variant.rightness) return false;
        return text != null ? text.equals(variant.text) : variant.text == null;

    }
    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (rightness ? 1 : 0);
        return result;
    }
    /* (non-Javadoc)
             * @see java.lang.Object#toString()
             */
    @Override
    public String toString() {
        return "Variant{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", number=" + number +
                ", rightness=" + rightness +
                '}';
    }
}
