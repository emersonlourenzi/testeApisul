import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevador implements IElevadorService {
    private String andar;
    private String elevador;
    private String turno;

    JSONObject jsonObject = null;
    JSONArray jsonArray = null;

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getElevador() {
        return elevador;
    }

    public void setElevador(String elevador) {
        this.elevador = elevador;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public JSONArray lendoDados() {
            try {
                FileReader fileReader = new FileReader
                        ("C:\\Users\\emerson\\Desktop\\testeApisul\\src\\main\\java\\input.json");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
//                    stringBuilder = stringBuilder.append(line);
                    stringBuilder.append(line);
                }

                bufferedReader.close();
                fileReader.close();

                JSONParser parser = new JSONParser();

                Object object;

                object = parser.parse(stringBuilder.toString());
                jsonArray = (JSONArray) object;
                return jsonArray;
            }catch (IOException | ParseException e){
                e.printStackTrace();
                return null;
            }
    }

    @Override
    public List<Integer> andarMenosUtilizado() {
        int a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0, a8 = 0, a9 = 0, a10 = 0,
                a11 = 0, a12 = 0, a13 = 0, a14 = 0, a15 = 0, a16 = 0;
        JSONArray jsonArray = lendoDados();
        List<Integer> listaAndar = new ArrayList<>();
        for (Object o:jsonArray) {
            jsonObject = (JSONObject) o;
            switch (jsonObject.get("andar").toString()) {
                case "0":
                    a1++;
                    break;
                case "1":
                    a2++;
                    break;
                case "2":
                    a3++;
                    break;
                case "3":
                    a4++;
                    break;
                case "4":
                    a5++;
                    break;
                case "5":
                    a6++;
                    break;
                case "6":
                    a7++;
                    break;
                case "7":
                    a8++;
                    break;
                case "8":
                    a9++;
                    break;
                case "9":
                    a10++;
                    break;
                case "10":
                    a11++;
                    break;
                case "11":
                    a12++;
                    break;
                case "12":
                    a13++;
                    break;
                case "13":
                    a14++;
                    break;
                case "14":
                    a15++;
                    break;
                case "15":
                    a16++;
                    break;
            }
        }

        ArrayList<Integer> andar = new ArrayList<>();

        andar.add(0,a1);
        andar.add(1,a2);
        andar.add(2,a3);
        andar.add(3,a4);
        andar.add(4,a5);
        andar.add(5,a6);
        andar.add(6,a7);
        andar.add(7,a8);
        andar.add(8,a9);
        andar.add(9,a10);
        andar.add(10,a11);
        andar.add(11,a12);
        andar.add(12,a13);
        andar.add(13,a14);
        andar.add(14,a15);
        andar.add(15,a16);

        Collections.sort(andar);

        ArrayList<Integer> andares = new ArrayList<>();

        for (int index : andar) {
            if ((index == a1) && (!andares.contains(0))) {
                andares.add(0);
            }
            else if ((index == a2) && (!andares.contains(1))) {
                andares.add(1);
            }
            else if ((index == a3) && (!andares.contains(2))) {
                andares.add(2);
            }
            else if ((index == a4) && (!andares.contains(3))) {
                andares.add(3);
            }
            else if ((index == a5) && (!andares.contains(4))) {
                andares.add(4);
            }
            else if ((index == a6) && (!andares.contains(5))) {
                andares.add(5);
            }
            else if ((index == a7) && (!andares.contains(6))) {
                andares.add(6);
            }
            else if ((index == a8) && (!andares.contains(7))) {
                andares.add(7);
            }
            else if ((index == a9) && (!andares.contains(8))) {
                andares.add(8);
            }
            else if ((index == a10) && (!andares.contains(9))) {
                andares.add(9);
            }
            else if ((index == a11) && (!andares.contains(10))) {
                andares.add(10);
            }
            else if ((index == a12) && (!andares.contains(11))) {
                andares.add(11);
            }
            else if ((index == a13) && (!andares.contains(12))) {
                andares.add(12);
            }
            else if ((index == a14) && (!andares.contains(13))) {
                andares.add(13);
            }
            else if ((index == a15) && (!andares.contains(14))) {
                andares.add(14);
            }
            else if ((index == a16) && (!andares.contains(15))) {
                andares.add(15);
            }
        }

        return andares;
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        JSONArray jsonArray = lendoDados();
        int a = forPercentual("elevador","A");
        int b = forPercentual("elevador","B");
        int c = forPercentual("elevador","C");
        int d = forPercentual("elevador","D");
        int e = forPercentual("elevador","E");

        ArrayList<Integer> elevador = new ArrayList<>();
        elevador.add(0,a);
        elevador.add(1,b);
        elevador.add(2,c);
        elevador.add(3,d);
        elevador.add(4,e);

        Collections.sort(elevador);
        Collections.reverse(elevador);

        ArrayList<Character> elevadores = new ArrayList<>();

        for (int index : elevador) {
            if ((index == a) && (elevadores.indexOf('A') <= 0)) {
                elevadores.add('A');
            }
            else if ((index == b) && (elevadores.indexOf('B') <= 0)) {
                elevadores.add('B');
            }
            else if ((index == c) && (elevadores.indexOf('C') <= 0)) {
                elevadores.add('C');
            }
            else if ((index == d) && (elevadores.indexOf('D') <= 0)) {
                elevadores.add('D');
            }
            else if ((index == e) && (elevadores.indexOf('E') <= 0)) {
                elevadores.add('E');
            }
        }

        return elevadores;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        int m = 0, v = 0, n = 0;
        List<Character> elevadorMaisFrequentado = elevadorMaisFrequentado();
        List<Character> retorno = new ArrayList<>(Collections.singletonList(elevadorMaisFrequentado.get(0)));
        JSONArray jsonArray = lendoDados();

        for(Object o:jsonArray) {
            jsonObject = (JSONObject) o;
            if (jsonObject.get("elevador").equals(elevadorMaisFrequentado.get(0))) {
                if (jsonObject.get("turno").equals("M")) {
                    m++;
                }
                else if (jsonObject.get("turno").equals("V")) {
                    v++;
                }
                else if (jsonObject.get("turno").equals("N")) {
                    n++;
                }
            }
        }

        ArrayList<Integer> turno = new ArrayList<>();
        turno.add(0,m);
        turno.add(1,v);
        turno.add(2,n);

        Collections.sort(turno);
        Collections.reverse(turno);

        ArrayList<Character> turnos = new ArrayList<>();

        for (int index : turno) {
            if ((index == m) && (!turnos.contains('M'))) {
                turnos.add('M');
            }
            else if ((index == v) && (!turnos.contains('V'))) {
                turnos.add('V');
            }
            else if ((index == n) && (!turnos.contains('N'))) {
                turnos.add('N');
            }
        }

//        retorno.add(0, elevadorMaisFrequentado.get(0));
        retorno.add(1, turnos.get(0));

        return retorno;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        JSONArray jsonArray = lendoDados();
        int a = forPercentual("elevador","A");
        int b = forPercentual("elevador","B");
        int c = forPercentual("elevador","C");
        int d = forPercentual("elevador","D");
        int e = forPercentual("elevador","E");

        ArrayList<Integer> elevador = new ArrayList<>();
        elevador.add(0,a);
        elevador.add(1,b);
        elevador.add(2,c);
        elevador.add(3,d);
        elevador.add(4,e);

        Collections.sort(elevador);

        ArrayList<Character> elevadores = new ArrayList<>();

        for (int index : elevador) {
            if ((index == a) && (!elevadores.contains('A'))) {
                elevadores.add('A');
            } else if ((index == b) && (!elevadores.contains('B'))) {
                elevadores.add('B');
            } else if ((index == c) && (!elevadores.contains('C'))) {
                elevadores.add('C');
            } else if ((index == d) && (!elevadores.contains('D'))) {
                elevadores.add('D');
            } else if ((index == e) && (!elevadores.contains('E'))) {
                elevadores.add('E');
            }
        }

        return elevadores;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        int m = 0;
        int v = 0;
        int n = 0;
        List<Character> elevadorMenosFrequentado = elevadorMenosFrequentado();
        List<Character> retorno = new ArrayList<>(Collections.singletonList(elevadorMenosFrequentado.get(0)));
        JSONArray jsonArray = lendoDados();

        for(Object o:jsonArray) {
            jsonObject = (JSONObject) o;
            if (jsonObject.get("elevador").equals(elevadorMenosFrequentado.get(0))) {
                if (jsonObject.get("turno").equals("M")) {
                    m++;
                }
                else if (jsonObject.get("turno").equals("V")) {
                    v++;
                }
                else if (jsonObject.get("turno").equals("N")) {
                    n++;
                }
            }
        }

        ArrayList<Integer> turno = new ArrayList<>();
        turno.add(0,m);
        turno.add(1,v);
        turno.add(2,n);

        Collections.sort(turno);

        ArrayList<Character> turnos = new ArrayList<>();

        for (int index : turno) {
            if ((index == m) && (!turnos.contains('M'))) {
                turnos.add('M');
            }
            else if ((index == v) && (!turnos.contains('V'))) {
                turnos.add('V');
            }
            else if ((index == n) && (!turnos.contains('N'))) {
                turnos.add('N');
            }
        }

        Collections.sort(turnos);
        Collections.reverse(turnos);

        retorno.add(1, turnos.get(0));

        return retorno;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        int m = 0, v = 0, n = 0;

        JSONArray jsonArray = lendoDados();
        for (Object o:jsonArray) {
            jsonObject = (JSONObject) o;
            if (jsonObject.get("turno").equals("M")) {
                m++;
            }
            else if (jsonObject.get("turno").equals("V")) {
                v++;
            }
            else if (jsonObject.get("turno").equals("N")) {
                n++;
            }
        }

        ArrayList<Integer> turno = new ArrayList<>();
        turno.add(0,m);
        turno.add(1,v);
        turno.add(2,n);

        Collections.sort(turno);
        Collections.reverse(turno);

        ArrayList<Character> turnos = new ArrayList<>();

        for (int index : turno) {
            if ((index == m) && (!turnos.contains('M'))) {
                turnos.add('M');
            }
            else if ((index == v) && (!turnos.contains('V'))) {
                turnos.add('V');
            }
            else if ((index == n) && (!turnos.contains('N'))) {
                turnos.add('N');
            }
        }

        return turnos;
    }

    @Override
    public float percentualDeUsoElevadorA() {
        float a;
        float per;

        JSONArray jsonArray = lendoDados();

        a = forPercentual("elevador", "A");

        per = (a * 100) / jsonArray.size();
        per = (float) (Math.round(per * 100.0) / 100.0);

        return per;
    }

    @Override
    public float percentualDeUsoElevadorB() {
        float a = 0;
        float per;

        JSONArray jsonArray = lendoDados();

        a = forPercentual("elevador", "B");

        per = (a * 100) / jsonArray.size();
        per = (float) (Math.round(per * 100.0) / 100.0);

        return per;
    }

    @Override
    public float percentualDeUsoElevadorC() {
        float a = 0;
        float per;

        JSONArray jsonArray = lendoDados();

        a = forPercentual("elevador", "C");

        per = (a * 100) / jsonArray.size();
        per = (float) (Math.round(per * 100.0) / 100.0);

        return per;
    }

    @Override
    public float percentualDeUsoElevadorD() {
        float a = 0;
        float per;

        JSONArray jsonArray = lendoDados();

        a = forPercentual("elevador", "D");

        per = (a * 100) / jsonArray.size();
        per = (float) (Math.round(per * 100.0) / 100.0);

        return per;
    }

    @Override
    public float percentualDeUsoElevadorE() {
        float a = 0;
        float per;

        JSONArray jsonArray = lendoDados();

        a = forPercentual("elevador", "E");

        per = (a * 100) / jsonArray.size();
        per = (float) (Math.round(per * 100.0) / 100.0);

        return per;
    }

    private int forPercentual(String getObj, String equals) {
        int a = 0;
        for (Object o:jsonArray) {
            jsonObject = (JSONObject) o;
            if (jsonObject.get(getObj).equals(equals)) {
                a++;
            }
        }
        return a;
    }
}
