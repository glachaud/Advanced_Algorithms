public enum Sort {
  SELECTION,
  BUBBLE,
  MERGE,
  QUICK;



  public static void main(String[] args) {
    for (Sort p : Sort.values()) {
      System.out.printf("The value is %s \n",
              p.name());
    }
  }
}
