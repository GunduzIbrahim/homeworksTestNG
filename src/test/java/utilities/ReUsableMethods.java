package utilities;

public class ReUsableMethods{
    public String findLocationOfElementInSpecificTableCell(int row){

        String xpath = "//table[1]/tbody/tr[" + row + "]/td[4]";//table[1]//tbody//tr[1]/td[4]
        return xpath;

    }
}
