package GenericsExercises.GenericBox_01;

public class Box <T> {
    private T value;

    public Box (T value){
        this.value = value;
    }

    public T getValue (){
        return this.value;
    }
    @Override
    public String toString (){
        return String.format("%s: %s", value.getClass().getName(), getValue());
    }
}
