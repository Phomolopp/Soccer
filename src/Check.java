public class Check 
{
    String name;
    String position;
    String feet;
    int fee;

    public Check(String name, String position, String feet, int fee) {
        this.name = name;
        this.position = position;
        this.feet = feet;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFeet() {
        return feet;
    }

    public void setFeet(String feet) {
        this.feet = feet;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String toString() 
    {
        return name+"#"+position+"#"+feet+"#"+fee;
    }
    
    
}
