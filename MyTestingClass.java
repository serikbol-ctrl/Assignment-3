class MyTestingClass {
    int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id * 31 + 7; // custom hash
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTestingClass)) return false;
        MyTestingClass that = (MyTestingClass) o;
        return this.id == that.id;
    }

    @Override
    public String toString() {
        return "ID:" + id;
    }
}