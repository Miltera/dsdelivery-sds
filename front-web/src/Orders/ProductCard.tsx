import {ReactComponent as Pizza} from './pizza.svg'

function ProductCard(){
  return(
    <div className="order-card-container">
      <h3 className="order-card-title">
        Pizza Calabresa
      </h3>
      <Pizza className="order-card-image" />
      <h3 className="order-card-price">R$ 35,90</h3>
      <div className="order-card-description">
        <h3>Descrição</h3>
        <p>
          Teste de descrição do produto pizza de calabresa - App da Semana Dev Superior edição 2
        </p>
      </div>
    </div>
  )
}

export default ProductCard;