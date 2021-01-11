import ProductCard from "./ProductCard";

function ProductsList(){
  return(
    <div className="orders-list-container">
      <div className="orders-list-items">
        <ProductCard />
      </div>
    </div>
  )
}

export default ProductsList;