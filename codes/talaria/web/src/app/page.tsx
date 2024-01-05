import React from 'react';


const Home: React.FC = () => {
  return (
        <div style={{ backgroundColor: '#2b2b2b', color: '#c5c8c6', minHeight: '100vh' }}>
          {/* Header */}
          <header id="header" style={{ backgroundColor: '#007bff', color: 'white', textAlign: 'center', padding: '1em 0' }}>
            <h1>Talaria - Organisme Formateur</h1>
          </header>

      {/* Catalogue des Formations */}
      <section id="catalogue" style={{ padding: '2em 0' }}>
        <div className="container">
          <h2 className="text-center mb-4">Catalogue des Formations</h2>

          <div className="formation-container" style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center' }}>
            {/* Formation 1 */}
            <div className="formation-card" style={{ flexBasis: '300px', margin: '1em', border: '1px solid #ddd', borderRadius: '5px', overflow: 'hidden', transition: 'transform 0.3s' }}>
              <img src="https://via.placeholder.com/300" alt="Formation 1" style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
              <div className="formation-card-body" style={{ padding: '1em' }}>
                <h3 className="card-title">Formation TypeScript avec Clasp et QUnit</h3>
                <p className="card-text">Guide détaillé pour utiliser TypeScript avec Clasp et QUnit pour le développement Google Apps Script.</p>
              </div>
            </div>

            {/* Formation 2 */}
            <div className="formation-card" style={{ flexBasis: '300px', margin: '1em', border: '1px solid #ddd', borderRadius: '5px', overflow: 'hidden', transition: 'transform 0.3s' }}>
              <img src="https://via.placeholder.com/300" alt="Formation 2" style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
              <div className="formation-card-body" style={{ padding: '1em' }}>
                <h3 className="card-title">Formation React Avancée</h3>
                <p className="card-text">Approfondissez vos connaissances en React avec des concepts avancés et des bonnes pratiques de développement.</p>
              </div>
            </div>

            {/* Formation 3 */}
            <div className="formation-card" style={{ flexBasis: '300px', margin: '1em', border: '1px solid #ddd', borderRadius: '5px', overflow: 'hidden', transition: 'transform 0.3s' }}>
              <img src="https://via.placeholder.com/300" alt="Formation 3" style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
              <div className="formation-card-body" style={{ padding: '1em' }}>
                <h3 className="card-title">Formation UX Design</h3>
                <p className="card-text">Découvrez les principes fondamentaux de l'UX design et apprenez à créer des expériences utilisateur exceptionnelles.</p>
              </div>
            </div>

            {/* Formation 4 */}
            <div className="formation-card" style={{ flexBasis: '300px', margin: '1em', border: '1px solid #ddd', borderRadius: '5px', overflow: 'hidden', transition: 'transform 0.3s' }}>
              <img src="https://via.placeholder.com/300" alt="Formation 4" style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
              <div className="formation-card-body" style={{ padding: '1em' }}>
                <h3 className="card-title">Formation Python pour les Débutants</h3>
                <p className="card-text">Commencez votre parcours en programmation avec cette formation Python adaptée aux débutants.</p>
              </div>
            </div>

            {/* Formation 5 */}
            <div className="formation-card" style={{ flexBasis: '300px', margin: '1em', border: '1px solid #ddd', borderRadius: '5px', overflow: 'hidden', transition: 'transform 0.3s' }}>
              <img src="https://via.placeholder.com/300" alt="Formation 5" style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
              <div className="formation-card-body" style={{ padding: '1em' }}>
                <h3 className="card-title">Formation Gestion de Projet Agile</h3>
                <p className="card-text">Acquérez les compétences nécessaires pour gérer efficacement des projets avec les méthodologies agiles.</p>
              </div>
            </div>

          </div>
        </div>
      </section>
      {/* Footer */}
      <Footer />
    </div>
  );
};

const Footer: React.FC = () => {
  return (
    <footer style={{ backgroundColor: '#4285f4', color: 'white', padding: '2em 0', textAlign: 'center' }}>
      <p>&copy; 2024 Talaria - Organisme Formateur. Tous droits réservés.</p>
    </footer>
  );
};

export default Home;