import React from 'react';

const Footer: React.FC = () => {
  console.log('Pied de page affiché');

  return (
    <footer style={{ backgroundColor: '#4285f4', color: 'white', padding: '2em 0', textAlign: 'center' }}>
      <p>&copy; 2024 Talaria - Organisme Formateur. Tous droits réservés.</p>
    </footer>
  );
};

export default Footer;
