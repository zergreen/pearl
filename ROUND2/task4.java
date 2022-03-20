import java.util.Scanner;

class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        

        String txt = scan.nextLine();
        // double N = scan.nextDouble();

        // if(N >= 10000000){
        // NumberFormat formatter = new DecimalFormat("#0.0#############");
        // String tempS = formatter.format(N);
        // txt = tempS;
        // }
        // else txt = String.valueOf(N);

        String digit[] = { "ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า", "สิบ" };
        String lev[] = { "", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน", "ล้าน" };
        String symbol[] = { "เอ็ด", "ยี่" };
        String numString, karatxt = "";
        // String temp[] = txt.split("[.]");
        int point = 0, d = 0;

        double decTemp = 0.0;
        String value = "", decimal = "", decTempS = "";
        point = txt.indexOf('.');

        if (point == -1) {
            value = txt;
            decimal = "0";
        } else {
            value = txt.substring(0, point);
            decimal = txt.substring(point + 1);
            decTempS = "0." + decimal;
            decTemp = Double.parseDouble(decTempS);
            decimal = String.valueOf(decTemp);
            d = decimal.indexOf('.');
            decimal = decimal.substring(d + 1);
        }
        int sizeVal = value.length();
        int sizeDec = decimal.length();

        String temp10[] = new String[8];
        String temp100[] = new String[9];
        String temp1000[] = new String[10];
        String valueM = "";
        String valueTempM = "";

        if (Integer.parseInt(value) < 10000000) {
            valueTempM = value;
        }

        if (Integer.parseInt(value) >= 10000000) {
            if (Integer.parseInt(value) >= 10000000 && Integer.parseInt(value) < 100000000) {
                for (int i = 0; i < sizeVal; i++) {
                    numString = value.substring(i, i + 1);
                    if (i < 2) {
                        temp10[i] = numString;
                        valueM = temp10[0] + temp10[1];
                    }
                    if (i >= 2) {
                        temp10[i] = numString;
                        valueTempM += temp10[i];
                    }
                }
            }

            else if (Integer.parseInt(value) >= 100000000 && Integer.parseInt(value) < 1000000000) {
                for (int i = 0; i < sizeVal; i++) {
                    numString = value.substring(i, i + 1);
                    if (i < 3) {
                        temp100[i] = numString;
                        valueM = temp100[0] + temp100[1] + temp100[2];
                    }
                    if (i >= 3) {
                        temp100[i] = numString;
                        valueTempM += temp100[i];
                    }
                }
            }

            else if (Integer.parseInt(value) >= 1000000000 && Integer.parseInt(value) <= 2000000000) {
                for (int i = 0; i < sizeVal; i++) {
                    numString = value.substring(i, i + 1);
                    if (i < 4) {
                        temp1000[i] = numString;
                        valueM = temp1000[0] + temp1000[1] + temp1000[2] + temp1000[3];
                    }
                    if (i >= 4) {
                        temp1000[i] = numString;
                        valueTempM += temp1000[i];
                    }
                }
            }

            for (int i = 0; i < valueM.length(); i++) {
                numString = valueM.substring(i, i + 1);
                if (Integer.parseInt(numString) != 0) {
                    if ((i == (valueM.length() - 1)) && (numString.indexOf("1") > -1)
                            && valueM.charAt(valueM.length() - 2) != '0')
                        karatxt += symbol[0];
                    else if ((i == (valueM.length() - 2)) && (numString.indexOf("2") > -1))
                        karatxt += symbol[1];
                    else if ((i == (valueM.length() - 2)) && (numString.indexOf("1") > -1))
                        karatxt += "";
                    else
                        karatxt += digit[Integer.parseInt(numString)];
                    karatxt += lev[(valueM.length() - i) - 1];
                }
            }
            karatxt += "ล้าน";
            if (Integer.parseInt(valueTempM) != 0)
                value = valueTempM;
        }

        if (Integer.parseInt(value) < 10000000) {

            for (int i = 0; i < value.length(); i++) {
                numString = value.substring(i, i + 1);
                if (Integer.parseInt(value) == 0) {
                    karatxt += digit[0];
                    break;
                }
                if (Integer.parseInt(value) == 1) {
                    karatxt += digit[1];
                    break;
                }
                if (Integer.parseInt(numString) != 0) {
                    if ((i == (value.length() - 1)) && (numString.indexOf("1") > -1)
                            && value.charAt(value.length() - 2) != '0')
                        karatxt += symbol[0];
                    else if ((i == (value.length() - 2)) && (numString.indexOf("2") > -1))
                        karatxt += symbol[1];
                    else if ((i == (value.length() - 2)) && (numString.indexOf("1") > -1))
                        karatxt += "";
                    else
                        karatxt += digit[Integer.parseInt(numString)];
                    karatxt += lev[(value.length() - i) - 1];
                }
                // if (i == 0 && Integer.parseInt(value) == 1) {
                // karatxt += digit[Integer.parseInt(numString)];
                // }
            }
        }

        if (Integer.parseInt(decimal) > 0) {
            karatxt += "จุด";
            for (int i = 0; i < sizeDec; i++) {
                numString = decimal.substring(i, i + 1);
                if (numString.indexOf("0") <= 0) {
                    karatxt += digit[Integer.parseInt(numString)];
                }
            }
            if (Integer.parseInt(decimal) == 0) {
                karatxt += "";
            }
        }
        System.out.println(karatxt);
    }
}
