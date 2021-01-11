import { checkIsSelected } from "./helpers";
import ProductCard from "./ProductCard";
import { Product } from "./types";

type Props = {
  products: Product[];
  selectedProducts: Product[];
  onSelectProduct: (prodduct: Product) => void;
}

function ProductsList({ products, selectedProducts, onSelectProduct }: Props){
  return(
    <div className="orders-list-container">
      <div className="orders-list-items">
        {products.map(p => (
          <ProductCard 
            key={p.id} 
            product={p}
            onSelectProduct={onSelectProduct}
            isSelected={checkIsSelected(selectedProducts, p)}
          />
        ))}        
      </div>
    </div>
  )
}

export default ProductsList;