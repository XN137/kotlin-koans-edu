<answer>fun renderProductTable(): String {
    return html {
        table {
            tr <taskWindow>(color = getTitleColor())</taskWindow> {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }
            val products = getProducts()
            <taskWindow>for ((index, product) in products.withIndex()) {
                tr {
                    td (color = getCellColor(index, 0)) {
                        text(product.description)
                    }
                    td (color = getCellColor(index, 1)) {
                        text(product.price)
                    }
                    td (color = getCellColor(index, 2)) {
                        text(product.popularity)
                    }
                }
            }</taskWindow>
        }
    }.toString()
}</answer>

fun getTitleColor() = "#b9c9fe"
fun getCellColor(index: Int, row: Int) = if ((index + row) %2 == 0) "#dce4ff" else "#eff2ff"