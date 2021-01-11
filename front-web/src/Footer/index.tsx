import './styles.css';
import {ReactComponent as Instagram} from './instagram.svg'
import {ReactComponent as Linkedin} from './linkedin.svg'
import {ReactComponent as Youtube} from './youtube.svg'

function Footer(){
    return(
      <footer className="main-footer">
        App desenvolvido durante a 2a edição do evento Semana Dev Superior
        <div className="footer-icons">
          <a href="www.youtube.com/c/DevSuperior" target="_new">
            <Youtube />
          </a>
          <a href="www.linkedin.com/school/devsuperior" target="_new">
            <Linkedin />
          </a>
          <a href="www.instagram.com/devsuperior.ig/" target="_new">
            <Instagram />
          </a>
        </div>
      </footer>
    )
}

export default Footer;