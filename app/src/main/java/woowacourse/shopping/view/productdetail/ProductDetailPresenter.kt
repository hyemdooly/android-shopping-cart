package woowacourse.shopping.view.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import woowacourse.shopping.domain.repository.CartRepository
import woowacourse.shopping.domain.repository.RecentViewedRepository
import woowacourse.shopping.model.ProductModel

class ProductDetailPresenter(
    initialCount: Int,
    private val product: ProductModel?,
    private val lastViewedProduct: ProductModel?,
    private val view: ProductDetailContract.View,
    private val cartRepository: CartRepository,
    private val recentViewedRepository: RecentViewedRepository,
) : ProductDetailContract.Presenter {
    private val _count: MutableLiveData<Int> = MutableLiveData<Int>(initialCount)
    override val count: LiveData<Int>
        get() = _count

    override fun fetchProduct() {
        if (product == null) {
            view.forceQuit()
        } else {
            updateRecentViewedProducts(product.id)
            view.setUpProductDetailView(product)
            if (lastViewedProduct != null) view.setUpLastViewedProductView(lastViewedProduct)
            view.setUpDialogBinding(product)
        }
    }

    override fun putInCart(product: ProductModel) {
        if (_count.value != null) cartRepository.add(product.id, _count.value ?: 0)
        view.finishActivity(true)
    }

    private fun updateRecentViewedProducts(id: Int) {
        recentViewedRepository.add(id)
    }

    override fun plusCount() {
        _count.value = _count.value?.plus(1)
    }

    override fun minusCount() {
        if ((_count.value ?: 1) > COUNT_MIN + 1) _count.value = _count.value?.minus(1)
    }

    companion object {
        private const val COUNT_MIN = 1
    }
}
