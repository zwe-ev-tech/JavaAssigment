public class Utils {

    //Method to search user from the list
    public static Change searchName(int numRecords, Change[] changeRecords, String name) {
        for (int v = 0; v < numRecords; v++) {
            var clientName = changeRecords[v].getName().toLowerCase();
            if (clientName.equals(name.toLowerCase())) {
                return changeRecords[v];
            }
        }
        return null;
    }

    public static Integer ParseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
