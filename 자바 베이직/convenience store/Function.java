package convenience_store;

import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;

public class Function {
    static void showMenu(){
        System.out.println("1. 물건 정보(제품명) 등록하기");
        System.out.println("2. 물건 정보(제품명) 등록 취소하기");
        System.out.println("3. 물건 넣기 (제품 입고)");
        System.out.println("4. 물건 빼기 (제품 출고)");
        System.out.println("5. 재고 조회");
        System.out.println("6. 프로그램 종료");
        System.out.println("-".repeat(30));
    }
    static int selectMenu(BufferedReader bf, List<Product> itemList) throws IOException {
        System.out.print("[System] 원하는 기능의 번호를 입력하세요 : ");
        return Integer.parseInt(bf.readLine());
    }
    static void register(BufferedReader bf, List<Product> itemList) throws IOException {
        System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");

        String str = bf.readLine();
        Product p = new Product(str);
        itemList.add(p);

        System.out.println("[System] 등록이 완료되었습니다.");
        System.out.println("[System] 현재 등록된 제품 목록 ▼");

        itemList.stream().forEach(item -> System.out.println("> " + item.getItem()));
        System.out.println("-".repeat(30));
    }
    static void delete(BufferedReader bf, List<Product> itemList) throws IOException {
        System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String str = bf.readLine();
        int cnt = 0;

        for (int i = 0; i < itemList.size(); i++)
            if (itemList.get(i).getItem().compareTo(str) == 0) {
                itemList.remove(i);
                cnt = i;
                break;
            }
        //itemList.stream().map(Product::getItem).dropWhile(i -> i.equals(str));

        if (cnt == itemList.size())
            System.out.println("[System] 제품이 등록된 리스트에 없습니다!!");
        else System.out.println("[System] 제품 취소가 완료됬습니다.");
    }
    static void addAmount(BufferedReader bf, List<Product> itemList) throws IOException {
        System.out.println("[System] 물건의 수량을 추가합니다.(입고)");
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        itemList.stream().forEach(item -> System.out.printf("> %s : %d개\n", item.getItem(), item.getAmount()));

        System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String str = bf.readLine();
        System.out.print("[System] 추가할 수량을 입력해주세요 : ");
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < itemList.size(); i++)
            if (itemList.get(i).getItem().compareTo(str) == 0) {
                itemList.get(i).addAmount(n);
                break;
            }

        System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료되었습니다.");
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        itemList.stream().forEach(item -> System.out.printf("> %s : %d개\n", item.getItem(), item.getAmount()));
    }
    static void subAmount(BufferedReader bf, List<Product> itemList) throws IOException {
        System.out.println("[System] 제품의 출고를 진행합니다.");
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        itemList.stream().forEach(item -> System.out.printf("> %s : %d개\n", item.getItem(), item.getAmount()));

        System.out.print("[System] 출고를 진행할 제품명을 입력하세요 : ");
        String str = bf.readLine();
        System.out.print("[System] 원하는 출고량을 입력하세요 : ");
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < itemList.size(); i++)
            if (itemList.get(i).getItem().compareTo(str) == 0) {
                if (itemList.get(i).getAmount() - n < 0)
                    System.out.println("[System] 출고량이 재고보다 많습니다!!!");
                else {
                    itemList.get(i).subAmount(n);
                    System.out.println("[Clear] 출고가 완료되었습니다.");
                }
                break;
            }

        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        itemList.stream().forEach(item -> System.out.printf("> %s : %d개\n", item.getItem(), item.getAmount()));
    }
    static void stock(List<Product> itemList) {
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        itemList.stream().forEach(item -> System.out.printf("> %s : %d개\n", item.getItem(), item.getAmount()));
    }
}
