package woowacourse.shopping.view.productlist

import woowacourse.shopping.domain.ProductRepository
import woowacourse.shopping.model.toUiModel

class ProductListPresenter(
    private val view: ProductListContract.View,
    private val productRepository: ProductRepository,
) : ProductListContract.Presenter {
    override fun fetchProducts() {
        val products = productRepository.findAll()
        view.showProducts(products.map { it.toUiModel() })
    }
}
