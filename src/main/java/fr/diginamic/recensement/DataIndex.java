package fr.diginamic.recensement;

public enum DataIndex {
    CodeRegion(0), NomRegion(1), CodeDepartement(2), CodeArrondissement(3), CodeCanton(4), CodeCommune(5), NomCommune(6), PopMunicipale(7), PopAPart(8), PopTotal(9);

    private int dataIndex;

    DataIndex(int dataIndex){
        this.dataIndex = dataIndex;
    }

    public int getDataIndex(){
        return dataIndex;
    }
}
