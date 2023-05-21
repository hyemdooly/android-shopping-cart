package woowacourse.shopping.domain

class ProductListPagination(
    private val rangeSize: Int,
    private val productRepository: ProductRepository
) : NextPagination<Product> {
    private var mark = 0

    override fun nextItems(): List<Product> {
        if (isNextEnabled) {
            val items = productRepository.findRange(mark, rangeSize)
            mark += rangeSize
            return items
        }
        return emptyList()
    }

    override fun nextItemExist(): Boolean {
        return productRepository.isExistByMark(mark)
    }
}
