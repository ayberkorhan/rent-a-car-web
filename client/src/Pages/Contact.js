import MainMenu from '../Components/MainMenu';

function Contact() {

  return (<div className='w-full h-full bg-gray-800 text-white font-serif'>


      <div className='flex flex-col flex-wrap w-full h-screen justify-center items-center  '>
        <MainMenu/>

        <div className='flex w-5/6  m-2 p-2 h-5/6  items-center font-serif'>
          <ul className='p-2 m-2'>
            <li>
              <h1 className='text-2xl pb-5'>İletişim Bilgisi</h1>
              <address className='text-md'>Bilişim Vadisi, Muallimköy Mahallesi Deniz Caddesi No:143/1 41400 Gebze
                Kocaeli-Türkiye
              </address>
            </li>
            <li className='pt-5'><a href='tel:021222222'>Telefon : 0212 222 33 44</a></li>
            <li className='pt-5'><a href='mailto:menesahin99@gmail.com'>Mail : menesahin99@gmail.com</a></li>
          </ul>

          <iframe
            src='https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3020.6436288960263!2d29.50972221524418!3d40.791848179323324!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x14cb2125cd43d025%3A0xb7117d063d36362c!2zVMOcUkvEsFlF4oCZTsSwTiBPVE9NT0LEsEzEsCBHxLBSxLDFnsSwTSBHUlVCVSBTQU5BWcSwIFZFIFTEsENBUkVUIEEuxZ4!5e0!3m2!1str!2str!4v1643364178079!5m2!1str!2str'
            allowFullScreen=''
            loading='lazy'
            className='w-5/6 h-5/6' />
        </div>
      </div>


    </div>
  );

}

export default Contact;