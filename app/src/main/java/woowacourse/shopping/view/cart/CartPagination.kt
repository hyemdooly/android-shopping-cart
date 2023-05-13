package woowacourse.shopping.view.cart

import woowacourse.shopping.domain.CartProduct
import woowacourse.shopping.domain.CartRepository
import woowacourse.shopping.model.CartPageStatus
import woowacourse.shopping.model.NextPagination
import woowacourse.shopping.model.PrevPagination

class CartPagination(private val rangeSize: Int, private val cartRepository: CartRepository) :
    NextPagination<CartProduct>, PrevPagination<CartProduct> {
    private var mark = 0
    private val page: Int
        get() = mark / rangeSize
    val status: CartPageStatus
        get() = CartPageStatus(isPrevEnabled, isNextEnabled, page)

    override fun nextItems(): List<CartProduct> {
        if (nextItemExist()) {
            val items = cartRepository.findRange(mark, rangeSize)
            mark += rangeSize
            return items
        }
        return emptyList()
    }

    override fun prevItems(): List<CartProduct> {
        if (prevItemExist()) {
            mark -= rangeSize
            return cartRepository.findRange(mark - rangeSize, rangeSize)
        }
        return emptyList()
    }

    override fun nextItemExist(): Boolean {
        return cartRepository.isExistByMark(mark)
    }

    override fun prevItemExist(): Boolean {
        return cartRepository.isExistByMark(mark - rangeSize - 1)
    }
}
