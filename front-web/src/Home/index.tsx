import './styles.css';
import {ReactComponent as Main} from './main.svg'

function Home(){
    return(
      <div className="home-container">
        <div className="home-content">
          <div className="home-action">
            <h1 className="home-title">
              Faça seu pedido <br/> que entregamos <br/> para você!            
            </h1>
            <h3 className="home-subtitle">
              Escolha o seu pedido e em poucos minutos <br/> lhe entregaremos em sua porta
            </h3>
            <a href="orders" className="home-btn-order">
              FAZER PEDIDOS      
            </a>            
          </div>
          <div className="home-image">
            <Main />
          </div>
        </div>        
      </div>
    )
}

export default Home;