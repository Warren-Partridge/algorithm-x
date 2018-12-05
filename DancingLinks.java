// Data structures implemented from pg. 5 of Dancing Links paper

// Ok, just so it makes sense to me:
// Data Object = a dancing link. It has 2 circularly linked lists and a list header.
// Column Object = a column (a set of 1s that we may want to have in our exact cover). It contains DOs and has a name and # of DOs.

public class DancingLinks {
    class DataObject {
        DataObject L, R, U, D;
        ColumnObject C; // Knuth calls this property a "list header" in his paper but I am conflating the two objects into one for simplicity

        DataObject() {
            L = R = U = D = this;
        }

        DataObject(ColumnObject initC) {
            this();
            C = initC;
            // TODO: Stick on bottom of col by default?
        }

        DataObject appendToRow(DataObject newDO) { // Append new DO to the right and return it
            this.R.L = newDO;
            newDO.L = this;
            newDO.R = this.R;
            this.R = newDO;

            return newDO;
        }

        DataObject appendToColumn(DataObject newDO) { // Append new DO below and return it
            this.D.U = newDO;
            newDO.U = this;
            newDO.D = this.D;
            this.D = newDO;

            return newDO;
        }

        void unlinkFromRow() {
            this.L.R = this.R;
            this.R.L = this.L;
        }

        void relinkToRow() {
            this.L.R = this.R.L = this;
        }

        void unlinkFromColumn() {
            this.U.D = this.D;
            this.D.U = this.U;
        }

        void relinkToColumn() {
            this.U.D = this.D.U = this;
        }

    }

    class ColumnObject extends DancingLinks {
//        DataObject L, R, U, D;
//        ColumnObject C;
        String name;
        int size; // Number of 1s in the column

        ColumnObject(String initName) {
            super(); // Inherit L,R,U,D,C from dataobject
            C = this;
            name = initName;
            size = 0;
        }



    }



    public void search() { // Deterministic algorithm to find all exact covers
        // TODO
    }


}