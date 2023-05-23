# android-shopping-cart
## Domain
### ProductRepository
- [x] 상품 목록을 가져올 수 있다.
### CartRepository
- [x] 장바구니의 상품 목록을 가져올 수 있다.
- [x] 장바구니에 상품을 추가할 수 있다.
- [x] 장바구니에 상품을 삭제할 수 있다.
### Product
- name : 이름
- imageUrl : 이미지 URL
- price : 가격
### Price
- price : 가격
## View
- [x] 앱이 종료돼도 최근 본 상품 목록과 장바구니 데이터는 유지돼야 한다.
### ProductListActivity
- [x] 상품을 클릭하면 상품 상세로 이동한다.
- [X] 툴바 안의 카트 버튼을 누르면 장바구니로 이동한다.
- [x] 툴바 안의 카트 옆에 장바구니 상품 수가 노출된다.
- [x] 상품 목록의 +버튼을 누르면 장바구니에 상품이 추가된다.
- [x] +버튼을 누른 후 동시에 수량 선택 버튼이 노출된다.
- [x] 상품 목록의 상품 수가 변화하면 장바구니에 반영된다.
- [x] 장바구니 상품 수가 변화하면 상품 목록에도 반영된다.
### ProductDetailActivity
- [x] 사용자는 상품을 장바구니에 추가할 수 있다.
- [x] 마지막으로 본 상품 1개를 상품 상세 페이지에서 확인할 수 있다.
- [x] 마지막으로 본 상품을 선택했을 때는 마지막으로 본 상품이 보이지 않는다.
- [x] 마지막으로 본 상품 페이지에서 뒤로 가기를 하면 상품 목록으로 이동한다.
### CartActivity
- [x] 장바구니에서 원하는 상품을 삭제할 수 있다.
- [X] 툴바 안의 백버튼을 누르면 뒤로 이동한다.
- [x] 체크박스로 주문할 상품 범위를 조정할 할 수 있다.
- [x] 전체 체크박스를 선택하면 해당 페이지 내의 상품들만 선택된다.
- [x] 페이지가 바뀌어도 선택 항목은 유지된다.
